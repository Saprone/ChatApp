import { mount } from '@vue/test-utils'
import Login from '@/views/Login.vue'

describe('Login.vue', () => {
  it('test username input', () => {
    const wrapper = mount(Login)
    const input_username = wrapper.findComponent({ref: 'username'})
    input_username.setValue('admin')

    expect(input_username.element.value).toBe('admin')
  })
})
describe('Login.vue, () => {
  it('test password input', () => {
    const wrapper = mount(Login)
    const input_password = wrapper.findComponent({ref: 'password'})
    input_password.setValue('1234')

    expect(input_password.element.value).toBe('1234')
  })
}) 