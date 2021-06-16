import axios from 'axios';
import authHeader from './auth-header';
import Artist from "@/components/Artist";

const API_URL = 'http://localhost:8080/api/v1/';

class CollectionService {
    getAllCollections() {
        return axios.get(API_URL + 'collezioni', {headers: authHeader() })}

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}

export default new CollectionService();