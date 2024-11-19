package lookids.comment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.comment.common.vo.CountResponseVo;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountResponseDto {

	private long page;
	// private Integer totalPage;
	// private Boolean nextPage;
	// private List<?> data;

	public static CountResponseDto toDto(long page) {
		return CountResponseDto.builder()
			.page(page)
			.build();
	}

	public CountResponseVo toVo() {
		return CountResponseVo.builder()
			.page(this.page)
			.build();
	}
}
