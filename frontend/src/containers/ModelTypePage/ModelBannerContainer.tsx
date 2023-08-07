import { styled } from 'styled-components';
import { BodyKrRegular5, HeadingKrRegular2 } from '../../styles/typefaces';
import CenterWrapper from '../../components/layout/CenterWrapper';
import Banner from '../../components/banner/Banner';
import HmgTag from '../../components/hmgTag/HmgTag';
import PriceStaticBar from '../../components/priceStaticBar/PriceStaticBar';

export default function ModelBannerContainer() {
  return (
    <>
      <PriceStaticBar />
      <Banner
        subtitle={'파워트레인'}
        title={'디젤 2.2'}
        desc={'높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다'}
      >
        <Container>
          <HmgDataSection>
            <HmgTag size="small" />
            <DataList>
              <Data>
                <DataTitle>최고출력(PS/rpm)</DataTitle>
                <DataInfo>
                  202/3,800
                  <DataRatio>
                    <Ratio $current={0.49} $max={0.53}></Ratio>
                  </DataRatio>
                </DataInfo>
              </Data>
              <Data className="separator" />
              <Data>
                <DataTitle>최대토크(kgf·m/rpm)</DataTitle>
                <DataInfo>
                  45/1,750-2,750
                  <DataRatio>
                    <Ratio $current={0.005} $max={0.02}></Ratio>
                  </DataRatio>
                </DataInfo>
              </Data>
            </DataList>
          </HmgDataSection>
          <ImgSection />
        </Container>
      </Banner>
    </>
  );
}

const Container = styled(CenterWrapper)`
  display: flex;
  justify-content: space-between;
  height: 100%;
  height: 100%;
`;
const HmgDataSection = styled.div`
  padding-top: 202px;
`;

const DataList = styled.ul`
  display: flex;
  width: 448px;
  margin-top: 16px;
  align-items: center;
`;
const Data = styled.li`
  width: 100%;
  height: 67px;
  display: flex;
  flex-direction: column;
  &:first-child {
    padding-right: 24px;
  }

  &:last-child {
    padding-left: 24px;
  }

  &.separator {
    width: 1px;
    height: 41px;
    background-color: ${({ theme }) => theme.color.gray200};
  }
`;
const DataTitle = styled.div`
  margin-bottom: 8px;
  ${BodyKrRegular5}
  color: ${({ theme }) => theme.color.gray600};
`;
const DataInfo = styled.div`
  ${HeadingKrRegular2}
`;
const DataRatio = styled.div`
  height: 4px;
  background-color: ${({ theme }) => theme.color.gray200};
`;
const Ratio = styled.div<{ $current: number; $max: number }>`
  height: 4px;
  width: ${(props) => (props.$current / props.$max) * 100}%;
  background-color: ${({ theme }) => theme.color.activeBlue2};
`;

const ImgSection = styled.div`
  width: 632px;
  height: 360px;
  background-image: url('/images/model_engine.png');
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
`;