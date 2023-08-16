package autoever2.cartag.service;

import autoever2.cartag.domain.model.*;
import autoever2.cartag.exception.EmptyDataException;
import autoever2.cartag.repository.CarRepository;
import autoever2.cartag.repository.ModelRepository;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, SoftAssertionsExtension.class})
class ModelServiceTest {

    @InjectSoftAssertions
    SoftAssertions softAssertions;

    @InjectMocks
    private ModelService modelService;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private CarRepository carRepository;

    @Test
    @DisplayName("트림의 모델 리스트 반환")
    void getModelTypeData() {
        //given
        List<ModelShortMappedDto> trimModelList = new ArrayList<>();
        //디젤 2.2 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(1)
                .modelName("디젤 2.2")
                .modelPrice(0L)
                .isDefaultModel(true)
                .modelTypeName("파워트레인")
                .modelBoughtCount(1800L)
                .build());

        //가솔린 3.8 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(2)
                .modelName("가솔린 3.8")
                .modelPrice(280000L)
                .isDefaultModel(false)
                .modelTypeName("파워트레인")
                .modelBoughtCount(1900L)
                .build());

        //7인승 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(3)
                .modelName("7인승")
                .modelPrice(0L)
                .isDefaultModel(true)
                .modelTypeName("바디타입")
                .modelBoughtCount(900L)
                .build());

        //8인승 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(4)
                .modelName("8인승")
                .modelPrice(130000L)
                .isDefaultModel(false)
                .modelTypeName("바디타입")
                .modelBoughtCount(800L)
                .build());

        //2WD 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(5)
                .modelName("2WD")
                .modelPrice(0L)
                .isDefaultModel(true)
                .modelTypeName("구동방식")
                .modelBoughtCount(1200L)
                .build());

        //4WD 데이터
        trimModelList.add(ModelShortMappedDto.builder()
                .modelId(6)
                .modelName("4WD")
                .modelPrice(237000L)
                .isDefaultModel(false)
                .modelTypeName("구동방식")
                .modelBoughtCount(200L)
                .build());

        int carId = 1;
        Long boughtCount = 2000L;
        when(modelRepository.findAllModelTypeData(carId)).thenReturn(trimModelList);
        when(carRepository.findCarBoughtCountByCarId(carId)).thenReturn(Optional.of(2000L));

        //when
        List<ModelShortDataDto> result = modelService.getModelTypeData(carId);

        //then
        assertEquals(6, result.size());
        assertEquals(1, result.get(0).getModelId());
        assertEquals("가솔린 3.8", result.get(1).getModelName());
        assertEquals("바디타입", result.get(2).getModelTypeName());
        assertEquals(130000L, result.get(3).getModelPrice());
        assertEquals(10, result.get(5).getPercentage());
    }

    @Test
    @DisplayName("모델의 상세 데이터 반환")
    void getModelDetailData() {
        int modelId1 = 1;
        ModelDetailMappedDto model1 = ModelDetailMappedDto.builder()
                .modelTypeName("파워트레인")
                .modelName("디젤2.2")
                .optionDescription("높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다")
                .modelImage("/model/diesel2-2.jpg")
                .build();

        int modelId2 = 4;

        when(modelRepository.findModelDetailData(modelId1)).thenReturn(Optional.of(model1));

        ModelDetailMappedDto result1 = modelService.getModelDetail(modelId1);

        softAssertions.assertThat(result1).usingRecursiveComparison().isEqualTo(model1);
        softAssertions.assertThatThrownBy(() -> modelService.getModelDetail(4)).isInstanceOf(EmptyDataException.class);
    }

    @Test
    @DisplayName("파워트레인의 HMG 데이터 반환")
    void getPowerTrainData() {
        int powerTrainId1 = 1;
        PowerTrainMappedDto powerTrain1 = PowerTrainMappedDto.builder()
                .maxPs("202/3,800PS/rpm")
                .maxKgfm("45.0/1,750~2,750kgf-m/rpm")
                .build();

        int powerTrainId2 = 4;

        when(modelRepository.findPowerTrainData(powerTrainId1)).thenReturn(Optional.of(powerTrain1));

        PowerTrainMappedDto result1 = modelService.getPowerTrainHmgData(powerTrainId1);

        softAssertions.assertThat(result1).usingRecursiveComparison().isEqualTo(powerTrain1);
        softAssertions.assertThatThrownBy(() -> modelService.getPowerTrainHmgData(powerTrainId2)).isInstanceOf(EmptyDataException.class);
    }

    @Test
    @DisplayName("파워트레인과 구동방식의 조합으로 HMG 데이터 반환")
    void getEfficiencyData() {
        int powerTrainId = 1;
        int operationId = 3;
        ModelEfficiencyDataDto data = ModelEfficiencyDataDto.builder()
                .averageFuel("12.16km/s")
                .displacement("2,199cc")
                .build();

        when(modelRepository.findEfficiencyData(powerTrainId, operationId)).thenReturn(Optional.of(data));

        softAssertions.assertThat(modelService.getEfficiencyData(powerTrainId, operationId)).usingRecursiveComparison().isEqualTo(data);
        softAssertions.assertThatThrownBy(() -> modelService.getEfficiencyData(2, 4)).isInstanceOf(EmptyDataException.class);
    }
}