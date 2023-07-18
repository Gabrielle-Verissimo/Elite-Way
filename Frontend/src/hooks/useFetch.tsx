import axios from "axios";
import { useEffect, useState } from "react";
const api = 'http://localhost:8080/students';

interface Data {
    data: JSON;
    
}

interface Loading {
    isLoading: boolean;
}


function useFetch() {
    const [data, setData] = useState<Data[]>([]);
    const [isLoading, setIsLoading] = useState<Loading>({isLoading: true});

    useEffect(() => {
        axios.get(api)
            .then(res => setData(res.data))
            .catch(e => console.log(e))
            .finally(() => setIsLoading({isLoading: false}));
    }, [])

    return {data, isLoading};
}

export default useFetch;