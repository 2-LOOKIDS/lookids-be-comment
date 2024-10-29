package lookids.comment.comment.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.comment.comment.domain.Comment;
import lookids.comment.comment.vo.in.CommentRequestVo;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

	private String feedCode;
	private String userUuid;
	private String content;
	private String parentCommentCode;

	@Builder
	public CommentRequestDto(
		String feedCode,
		String userUuid,
		String content,
		String parentCommentCode
	) {
		this.feedCode = feedCode;
		this.userUuid = userUuid;
		this.content = content;
		this.parentCommentCode = parentCommentCode;
	}

	public static CommentRequestDto toDto(CommentRequestVo commentRequestVo) {
		return CommentRequestDto.builder()
			.feedCode(commentRequestVo.getFeedCode())
			.userUuid(commentRequestVo.getUserUuid())
			.content(commentRequestVo.getContent())
			.parentCommentCode(commentRequestVo.getParentCommentCode())
			.build();
		//dto로 전환을 시켜줌.
	}

	public Comment toEntity() {
		return Comment.builder()
			.feedCode(this.feedCode)
			.userUuid(this.userUuid)
			.content(this.content)
			.parentCommentCode(this.parentCommentCode)
			.build();
	}
}
