package com.iadsn.services;

import com.iadsn.entities.MembroEntity;
import com.iadsn.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MembroService {
    @Autowired
    MembroRepository membroRepository;

    public MembroEntity getMembroId(Long id){
        return membroRepository.findById(id).orElse(null);
    }

    public MembroEntity atualizarMembro(Long id, MembroEntity membroAtualizado, MultipartFile file) {
        MembroEntity membro = getMembroId(id);

        if (membro == null) {
            return null; // Ou lançar uma exceção
        }

        // Atualiza os campos básicos
        membro.setNome(membroAtualizado.getNome());
        membro.setNascimento(membroAtualizado.getNascimento());
        membro.setEmail(membroAtualizado.getEmail());
        membro.setCpf(membroAtualizado.getCpf());
        membro.setSexo(membroAtualizado.getSexo());
        membro.setStatusCivil(membroAtualizado.getStatusCivil());
        membro.setCargo(membroAtualizado.getCargo());
        membro.setEndereco(membroAtualizado.getEndereco());
        membro.setTelefone(membroAtualizado.getTelefone());
        membro.setArquivado(membroAtualizado.isArquivado());

        // Processa a foto (se uma nova foi enviada)
        if (file != null && !file.isEmpty()) {
            try {
                membro.setFoto(file.getBytes()); // Converte MultipartFile para byte[]
            } catch (IOException e) {
                System.out.println("Falha ao processar a foto");
                e.printStackTrace();
            }
        } // Se nenhum arquivo for enviado, a foto existente é mantida

        return membroRepository.save(membro);
    }

    public List<MembroEntity> getMembrosList(){
        return membroRepository.findAll();
    }

    public List<MembroEntity> getMembrosArquivados(){
        List<MembroEntity> membrosArquivados = membroRepository.findMembrosArquivados();
        if(!membrosArquivados.isEmpty()){
            return membrosArquivados;
        }
        return null;
    }

    public List<MembroEntity> getMembrosDesarquivados(){
        List<MembroEntity> membrosDesarquivados = membroRepository.findMembrosDesarquivados();
        if(!membrosDesarquivados.isEmpty()){
            return membrosDesarquivados;
        }
        return null;
    }

    public MembroEntity criarMembro(MembroEntity membro){
        membro.setId(null);
        if(membro.getMultipartFile() != null && !membro.getMultipartFile().isEmpty()){
            try{
                membro.setFoto(membro.getMultipartFile().getBytes());
            }catch (IOException e){
                System.out.println("Falha ao salvar foto no banco de dados");
                e.printStackTrace();
            }
        }
        return membroRepository.save(membro);
    }

    public void deletarMembro(Long id){
        MembroEntity membro = getMembroId(id);
        membroRepository.deleteById(membro.getId());
    }

    public MembroEntity arquivarMembroId(Long id){
        MembroEntity membro = getMembroId(id);
        if (membro != null && !membro.isArquivado()){
            membro.setArquivado(true);
            membroRepository.save(membro);
            return membro;
        }
        return null;
    }

    public MembroEntity desarquivarMembroId(Long id){
        MembroEntity membro = getMembroId(id);
        if (membro != null && membro.isArquivado()){
            membro.setArquivado(false);
            membroRepository.save(membro);
            return membro;
        }
        return null;
    }
}
