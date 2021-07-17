package com.sunclock.book.springbootMVC.service.posts;

import com.sunclock.book.springbootMVC.domain.posts.Posts;
import com.sunclock.book.springbootMVC.domain.posts.PostsRepository;
import com.sunclock.book.springbootMVC.web.dto.PostsListResponseDto;
import com.sunclock.book.springbootMVC.web.dto.PostsResponseDto;
import com.sunclock.book.springbootMVC.web.dto.PostsSaveRequestDto;
import com.sunclock.book.springbootMVC.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // it creates a constructor having every field declared with final statement as a parameter
// inject Bean object through constructor!
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).
                                                getId();
    }

    // there are no query to db in update()!
    // check out 'dirty checking' for more info.
    // thanks to JPA, in which entity is included in consistency context during entity manager is activated
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // this option contains range of transaction but improves selecting speed!
    // used when there's no CRUD function
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // == .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        postsRepository.delete(posts);
    }
}
