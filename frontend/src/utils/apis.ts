const { VITE_API_URL: BASE_API_URL, VITE_IMG_URL: BASE_IMG_URL } = import.meta.env;

export const TRIM_API = `${BASE_API_URL}/api/cars/types`;
export const MODEL_TYPE_API = `${BASE_API_URL}/api/modeltypes`;
export const IMG_URL = `${BASE_IMG_URL}`;
