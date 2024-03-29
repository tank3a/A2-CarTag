import { styled } from 'styled-components';
import { BodyKrRegular3 } from '../../styles/typefaces';
import { IMG_URL } from '../../utils/apis';

export interface ISummaryItem {
  imgSrc: string;
  itemName: string;
  selectedName: string;
  price: number;
  handleModifyClick: () => void;
}

export default function SummaryItem({
  imgSrc,
  itemName,
  selectedName,
  price,
  handleModifyClick,
}: ISummaryItem) {
  return (
    <Item>
      <Img src={IMG_URL + imgSrc} alt="요약" />
      <InfoWrapper>
        <LeftInfo>
          <ItemName>{itemName}</ItemName>
          <SelectedName>{selectedName}</SelectedName>
        </LeftInfo>
        <RightInfo>
          <ModifyButton aria-label="modify-btn" onClick={handleModifyClick}>
            수정하기
          </ModifyButton>
          <Price>+ {price.toLocaleString()}원</Price>
        </RightInfo>
      </InfoWrapper>
    </Item>
  );
}

const Item = styled.li`
  display: flex;
  justify-content: space-between;
  padding: 8px 0;
  height: 71px;
  border-bottom: 1px solid ${({ theme }) => theme.color.gray100};
`;
const Img = styled.img`
  width: 77px;
  height: 55px;
  object-fit: contain;
`;
const InfoWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 510px;
  height: 100%;
  ${BodyKrRegular3}
`;
const LeftInfo = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;
const RightInfo = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  text-align: right;
`;

const Price = styled.div``;
const ItemName = styled.div`
  color: ${({ theme }) => theme.color.gray500};
`;
const ModifyButton = styled.button`
  text-align: end;
  color: ${({ theme }) => theme.color.primaryColor};
  text-align: end;
`;
const SelectedName = styled.div``;
