import axios from "axios";

export const useHttp = (baseURL, headers) => {
  const instance = axios.create({
    baseURL,
    headers,
  });

  const get = async (url) => {
    try {
      const response = await instance.get(url);

      return response.data;
    } catch (error) {
      console.log(error);
    }
  };

  const post = async (url, data) => {
    try {
      const response = await instance.post(url, data);

      return response.data;
    } catch (error) {
      console.log(error);
    }
  };

  const put = async (url, data) => {
    try {
      const response = await instance.put(url, data);

      return response.data;
    } catch (error) {
      console.log(error);
    }
  };

  const _delete = async (url) => {
    try {
      await instance.delete(url);
    } catch (error) {
      console.log(error);
    }
  };

  return {
    get,
    post,
    put,
    _delete,
  };
};
