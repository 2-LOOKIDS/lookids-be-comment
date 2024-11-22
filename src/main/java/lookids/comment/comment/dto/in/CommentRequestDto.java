package lookids.comment.comment.dto.in;

import java.util.UUID;

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

	@Builder
	public CommentRequestDto(String feedCode, String userUuid, String content) {
		this.feedCode = feedCode;
		this.userUuid = userUuid;
		this.content = content;
	}

	public static CommentRequestDto toDto(CommentRequestVo commentRequestVo, String userUuid) {
		return CommentRequestDto.builder()
			.feedCode(commentRequestVo.getFeedCode())
			.userUuid(userUuid)
			.content(commentRequestVo.getContent())
			.build();
		//dto로 전환을 시켜줌.
	}

	public Comment toEntity() {
		return Comment.builder()
			.commentCode(UUID.randomUUID().toString())
			.feedCode(feedCode)
			.userUuid(userUuid)
			.content(content)
			.commentStatus(true)
			.build();
	}
}
