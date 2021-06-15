import axios from 'axios'

const SERVER_URL = 'http://localhost:8080/api/v1';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    // (C)reate
    createNew: (text, completed) => instance.post('addArtista', {title: text, completed: completed}),
    // (R)ead
    getAll: () => instance.get('artisti', {
        transformResponse: [function (data) {
            return data? JSON.parse(data)._embedded.todos : data;
        }]
    }),
    // (U)pdate
    updateForId: (id, text, completed) => instance.put('changeArtisti/'+id, {title: text, completed: completed}),
    // (D)elete
    removeForId: (id) => instance.delete('removeArtisti/'+id)
}
