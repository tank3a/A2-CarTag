package autoever2.cartag.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Schema(description = "파워트레인과 모델타입의 조합으로 나온 HMG 데이터를 반환")
public class ModelEfficiencyDataDto {

    @Schema(description = "연비", example = "12.16km/s")
    private String averageFuel;
    @Schema(description = "배기량", example = "2,199cc")
    private String displacement;

    @Builder
    public ModelEfficiencyDataDto(String averageFuel, String displacement) {
        this.averageFuel = averageFuel;
        this.displacement = displacement;
    }
}
