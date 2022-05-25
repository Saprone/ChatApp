/*import { mount, flushPromises } from '@vue/test-utils'
import axios from 'axios'
import User from "../models/user"

jest.mock("axios", () => ({
    post: () => Promise.resolve(new User('admin', '1234'))
}));

it('test login with username and password input', async () => {
  const wrapper = mount(AuthenticationService)   

  //await

  // Let's assert that we've called axios.get the right amount of times and
  // with the right parameters.
  expect(axios.post).toHaveBeenCalledTimes(1)
  expect(axios.post).toHaveBeenCalledWith('http://localhost:8082/api/login')

  // Wait until the DOM updates.
  await flushPromises()

  //expect()
})*/

import AuthenticationService from '@/services/AuthenticationService.js'

describe('AuthenticationService.js', () => {
  it('test if authenticateUser in AuthenticationService is a function', () => {
    expect(typeof AuthenticationService.authenticateUser).toBe('function')
  })
})  