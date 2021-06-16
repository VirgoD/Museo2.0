import axios from 'axios';
import authHeader from './auth-header';
import Artist from "@/components/Artist";

const API_URL = 'http://localhost:8080/api/v1/';

class ArtistService {

    getAllArtists() {
        return axios.get(API_URL + 'artisti' , {headers: authHeader() })}

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }

    createArtist(e) {
        return axios.get(API_URL +'addArtist', {headers: authHeader() })
    }
}

export default new ArtistService();