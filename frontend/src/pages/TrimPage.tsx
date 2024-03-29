import { useContext, useEffect } from 'react';
import TrimBannerContainer from '../containers/TrimPage/TrimBannerContainer';
import TrimSelectContainer from '../containers/TrimPage/TrimSelectContainer';
import { useFetch } from '../hooks/useFetch';
import { TRIM_API } from '../utils/apis';
import { ICartype, TrimContext } from '../context/PageProviders/TrimProvider';
import ErrorModal from '../components/modal/ErrorModal';
import { ItemContext } from '../context/ItemProvider';
import Loading from '../components/loading/Loading';

export default function TrimPage() {
  const { selectedItem } = useContext(ItemContext);
  const { data, loading, error } = useFetch<ICartype[]>(
    `${TRIM_API}?cartype=${selectedItem.cartype.id}`
  );
  const { setData, setLoading } = useContext(TrimContext);
  useEffect(() => {
    setData(data);
    setLoading(loading);
  }, [data, loading, setData, setLoading]);

  if (error) {
    return <ErrorModal message={error.message} />;
  }
  return (
    <>
      {data && !loading ? (
        <>
          <TrimBannerContainer />
          <TrimSelectContainer />
        </>
      ) : (
        <Loading />
      )}
    </>
  );
}
