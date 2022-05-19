import { mount } from '@vue/test-utils'
import Login from '@/views/Login.vue'

describe('Login.vue', () => {
  it('sets the username', () => {
    const wrapper = mount(Login)
    const input_username = wrapper.find({ref: 'username'})
    input_username.setValue('admin')

    expect(input_username.element.value).toBe('admin')
  })
})
describe('Login.vue', () => {
  it('sets the password', () => {
    const wrapper = mount(Login)
    const input_password = wrapper.find({ref: 'password'})
    input_password.setValue('1234')

    expect(input_password.element.value).toBe('1234')
  })
})  