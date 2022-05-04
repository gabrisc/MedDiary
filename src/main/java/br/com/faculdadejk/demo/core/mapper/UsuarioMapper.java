package br.com.faculdadejk.demo.core.mapper;

import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.model.vo.UsuarioVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "idUsuario", source = "usuarioVO.idUsuario")
    @Mapping(target = "nomeCompleto", source = "usuarioVO.nomeCompleto")
    @Mapping(target = "username", source = "usuarioVO.username")
    @Mapping(target = "password", source = "usuarioVO.password")
    @Mapping(target = "dataCriacao", source = "usuarioVO.dataCriacao")
    Usuario toUsuario(UsuarioVO usuarioVO);

    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    @Mapping(target = "nomeCompleto", source = "usuario.nomeCompleto")
    @Mapping(target = "username", source = "usuario.username")
    @Mapping(target = "password", source = "usuario.password")
    @Mapping(target = "dataCriacao", source = "usuario.dataCriacao")
    UsuarioVO toUsuarioVo(Usuario usuario);
}
