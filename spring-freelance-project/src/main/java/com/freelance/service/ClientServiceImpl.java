package com.freelance.service;

import com.freelance.model.Client;
import com.freelance.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
@Service
public class ClientServiceImpl implements IClientService{
    private IClientRepository clientRepository;
    @Autowired
    public void setClientRepository(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     *
     * @param client
     */
    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    /**
     *
     * @param client
     */
    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    /**
     *
     * @param clientId
     */

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }

    /**
     *
     * @param clientId
     * @return single client object
     */
    @Override
    public Client getById(int clientId) {
        return clientRepository.findById(clientId).get();
    }

    /**
     *
     * @return list of all client's
     */
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Client::getClientName))
                .collect(Collectors.toList());
    }
}
