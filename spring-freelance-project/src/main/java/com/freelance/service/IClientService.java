package com.freelance.service;

import com.freelance.model.Client;
import com.freelance.model.Projects;

import java.util.List;

public interface IClientService {
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int clientId);

    Client getById(int clientId);
    List<Client> getAll();
}
