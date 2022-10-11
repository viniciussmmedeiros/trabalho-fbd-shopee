import createGlobalState from 'react-create-global-state'

const stringifyUsuario = localStorage.getItem('usuario')

const usuario = JSON.parse(stringifyUsuario) || {}

const [_useUsuarioGlobal, UsuarioGlobalProvider] = createGlobalState(usuario)

const useUsuarioGlobal = () => {
  const [usuarioGlobal, _setUsuarioGlobal] = _useUsuarioGlobal()

  const setUsuarioGlobal = (usuario) => {
    localStorage.setItem('usuario', JSON.stringify(usuario))
    _setUsuarioGlobal(usuario)
  }
  return [usuarioGlobal, setUsuarioGlobal]
}

export { useUsuarioGlobal, UsuarioGlobalProvider }
