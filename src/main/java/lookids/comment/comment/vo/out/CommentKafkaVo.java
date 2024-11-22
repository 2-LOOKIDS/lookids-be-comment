package lookids.comment.comment.vo.out;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentKafkaVo {
	private String commentCode;
	private String feedCode;
	private String userUuid;
	private String content;
	private LocalDateTime createdAt;
}