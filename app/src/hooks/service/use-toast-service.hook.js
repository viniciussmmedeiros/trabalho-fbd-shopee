import { useMemo } from "react";

export const useToastService = () => {
  const setErrorToast = () => {};

  const setSuccessToast = () => {};

  return useMemo(
    () => ({
      setErrorToast,
      setSuccessToast,
    }),
    []
  );
};
