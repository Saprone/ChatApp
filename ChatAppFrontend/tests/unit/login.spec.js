//import { Mount } from '@vue/test-utils'
import Login from '@/views/Login.vue'

describe('Login.vue', () => {
  it('has data', () => {
    expect(typeof Login.data).toBe('function')
  })
})