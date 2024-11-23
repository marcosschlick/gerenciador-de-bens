import { useQuery } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { AssetData } from "../interface/AssetData";

const API_URL = "http://localhost:8080";

const fetchData = async (): AxiosPromise<AssetData[]> => {
    const response = axios.get(API_URL + "/asset")
    return response;
}

export function useAssetData() {
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ["asset-data"],
        retry: 2
    })
    return {
        ...query,
        data: query.data?.data
    }
}