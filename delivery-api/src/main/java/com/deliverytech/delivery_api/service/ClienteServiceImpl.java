package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ClienteDto;
import com.deliverytech.delivery_api.dto.ClienteResponseDto;
import com.deliverytech.delivery_api.entity.Cliente;
import com.deliverytech.delivery_api.entity.Produto;
import com.deliverytech.delivery_api.exception.BusinessException;
import com.deliverytech.delivery_api.repository.IClienteRepository;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private IClienteRepository clienteRepository;
     public ClienteServiceImpl(IClienteRepository repository) {
        this.clienteRepository = repository;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteResponseDto cadastrarCliente(ClienteDto dto) {

        // Verifica se já existe um cliente com o e-mail informado
              
         if (clienteRepository.existsByEmail(dto.getEmail())) {

            throw new BusinessException("E-mail já cadastrado: " + dto.getEmail());
            
        }
       

        // Converta o DTO recebido para a entidade Cliente
        Cliente cliente = modelMapper.map(dto, Cliente.class);


        // Define cliente como ativo
        cliente.setAtivo(true);

        Cliente salvo = clienteRepository.save(cliente);

        // Converte a entidade salva para um DTO de resposta e retorna
        return modelMapper.map(salvo, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto buscarClientePorId(Long id) {
        // Busca o cliente pelo ID. Se não encontrar, lança exceção personalizada
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

        // Converte a entidade Cliente para o DTO de resposta e retorna
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto atualizarCliente(Long id, ClienteDto dto) {
        // Busca o cliente pelo ID. Se não existir, lança exceção
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado. "));

        // Verifica se o e-mail foi alterado e se já está sendo usado por outro cliente
        if (!cliente.getEmail().equals(dto.getEmail()) && clienteRepository.existsByEmail(dto.getEmail())) {

            throw new BusinessException("E-mail já cadastrado: " + dto.getEmail());
            
        }

        // Atualiza os campos permitidos
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());

        // Salva as alterações no banco de dados
        Cliente atualizado = clienteRepository.save(cliente);

        return modelMapper.map(atualizado, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto ativarDesativarCliente(Long id) {
        // Busca o cliente pelo ID. Se não encontrar, lança exceção
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado. "));

        // Inverte o status atual do cliente (ativo <=> inativo)
        cliente.setAtivo(!cliente.isAtivo());

        // Salva o cliente com o novo status e retorna o DTO de resposta
        return modelMapper.map(clienteRepository.save(cliente), ClienteResponseDto.class);

    }

    @Override
    public List<ClienteResponseDto> listarClientesAtivos() {
        // Busca todos os clientes com status ativo no repositório
                // Coleta os resultados em uma lista
        List<Cliente> clientes = clienteRepository.findByAtivoTrue();
        List<ClienteResponseDto> dtos = clientes.stream().map(cliente -> modelMapper.map(cliente,ClienteResponseDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public ClienteResponseDto buscarClientePorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarClientePorEmail'");
    }

}
