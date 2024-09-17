import axios  from 'axios'

export const insertData = (message) => {
    return axios.post('http://localhost:8080/new', { message }, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
}