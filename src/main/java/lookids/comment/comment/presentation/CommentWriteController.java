package lookids.comment.comment.presentation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lookids.comment.comment.application.CommentService;
import lookids.comment.comment.dto.in.CommentRequestDto;
import lookids.comment.comment.vo.in.CommentRequestVo;
import lookids.comment.common.entity.BaseResponse;
import lookids.comment.common.entity.BaseResponseStatus;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/write/comment")
public class CommentWriteController {

	private final CommentService commentService;   //final들어가면 변경 불가능!!!!!!!

	@Operation(summary = "createComment API", description = "createComment API 입니다.")
	@PostMapping
	public BaseResponse<Void> createComment(@RequestBody CommentRequestVo commentRequestVo) {

		commentService.createComment(CommentRequestDto.toDto(commentRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "deleteComment API", description = "deleteComment API 입니다. 소프트 딜리트")
	@DeleteMapping
	public BaseResponse<Void> deleteComment(@RequestParam String commentCode) {
		commentService.deleteComment(commentCode);
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

}
