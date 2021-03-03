import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },
  save(topic) {
    return http.post('/topics', topic);
  },
  modify(id, modifiedTopic) {
    return http.put(`/topics/${id}`, modifiedTopic);
  },
  delete(id) {
    return http.delete(`/topics/${id}`);
  }


}
