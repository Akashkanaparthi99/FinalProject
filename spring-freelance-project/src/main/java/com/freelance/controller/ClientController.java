package com.freelance.controller;

import com.freelance.exceptions.ProjectNotFoundException;
import com.freelance.model.Client;
import com.freelance.model.Projects;
import com.freelance.service.IClientService;
import com.freelance.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Akash
 * @date - 17-05-2022
 * @project - E-Freelance-Website
 */
@RestController
@RequestMapping("/client-api")
public class ClientController {
    private IClientService clientService;
    @Autowired
    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }

    /**
     *
     * @param client
     * @return adds client and returns response entity message
     */
    @PostMapping("/clients")
    ResponseEntity<String> addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.ok("Client added");
    }

    /**
     *
     * @param client
     * @return update's client data and returns response entity message
     */
    @PutMapping("/clients")
    ResponseEntity<String> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return ResponseEntity.ok("Updated");
    }

    /**
     *
     * @param clientId
     * @return deletes the client by taking client Id
     */
    @DeleteMapping("/clients")
    ResponseEntity<String> deleteClient(@PathVariable("clientId") int clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Deleted");

    }

    /**
     *
     * @param clientId
     * @return gets client information
     */
    @GetMapping("/clients/get-by-id/{clientId}")
    ResponseEntity<Client> getById(@PathVariable("clientId") int clientId) {
        return ResponseEntity.ok(clientService.getById(clientId));
    }

}
