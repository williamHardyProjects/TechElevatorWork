import axios from 'axios';
const http = axios.create({
    baseURL: 'http://localhost:3000'
});


function getTopics() {
    return http.get(`/topics`)
               .then(response => response.data);
}

function getTopic(id) {
    return http.get(`/topics/${id}`)
               .then(response => response.data);
}

export {getTopics, getTopic}