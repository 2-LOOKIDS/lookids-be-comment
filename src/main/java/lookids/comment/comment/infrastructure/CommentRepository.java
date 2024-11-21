package lookids.comment.comment.infrastructure;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lookids.comment.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Page<Comment> findAllByFeedCodeAndCommentStatus(String feedCode, boolean commentStatus, Pageable pageable);

	Page<Comment> findAllByParentCommentCodeAndCommentStatus(String parentCommentCode, boolean commentStatus,
		Pageable pageable);

	Optional<Comment> findByCommentCodeAndUserUuidAndCommentStatus(String commentCode, String userUuid,
		boolean commentStatus);

	Optional<Comment> findByCommentCode(String commentCode);

	// 특정 피드에 속한 댓글 수를 카운팅
	@Query(name = "select count(*) from comment where feed_code = :feedCode", nativeQuery = true)
	long countCommentsByFeedCode(@Param("feedCode") String feedCode);
}