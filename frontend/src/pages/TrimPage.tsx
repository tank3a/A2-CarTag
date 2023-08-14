import TrimBannerContainer from '../containers/TrimPage/TrimBannerContainer';
import TrimSelectContainer from '../containers/TrimPage/TrimSelectContainer';
import { useFetch } from '../hooks/useFetch';
import { TRIM_API } from '../utils/apis';

interface ICartype {
  trim: string;
  carDefaultPrice: number;
  outerImage: string;
  innerImage: string;
  wheelImage: string;
  carDescription: string;
  options: [
    {
      optionName: string;
      optionImage: string;
      optionDescription: string;
      optionUsedCount: number;
    },
  ];
}
export default function TrimPage() {
  const params = {
    carType: '1',
  };

  const query = new URLSearchParams(params).toString();
  const { data, loading } = useFetch<ICartype[]>(`${TRIM_API}?${query}`);

  if (data) {
    console.log(data[0].trim, loading);
  }

  return (
    <>
      <TrimBannerContainer />
      <TrimSelectContainer />
    </>
  );
}
