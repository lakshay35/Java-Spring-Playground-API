package com.example.springbootexample.service;

import com.example.springbootexample.entity.Trade;
import com.example.springbootexample.model.DeleteResult;
import com.example.springbootexample.model.Response;
import com.example.springbootexample.repository.TradeRepository;
import com.example.springbootexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private UserRepository userRepository;

    public Response<Trade> addTrade(Trade trade) {
        Response<Trade> response = new Response<Trade>();

        try {
            response.setResponse(this.tradeRepository.save(trade));
            response.setStatusCode(HttpStatus.CREATED);
            response.setMessage("Trade successfully added/updated");
        } catch(Exception e) {
            response.setMessage(e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setResponse(null);
        }

        return response;
    }

    public Response<Trade> updateTrade(Trade trade) {
        Response<Trade> response = new Response<Trade>();

        try {
            if(this.tradeRepository.existsById(trade.getId())) {
                response.setResponse(this.tradeRepository.save(trade));
                response.setStatusCode(HttpStatus.OK);
                response.setMessage("Trade successfully added/updated");
            } else {
                response.setResponse(null);
                response.setStatusCode(HttpStatus.BAD_REQUEST);
                response.setMessage("Trade with id " + trade.getId() + " does not exist");
            }

        } catch(Exception e) {
            response.setMessage(e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setResponse(null);
        }

        return response;
    }

    public Response<DeleteResult> deleteTrade(int tradeId) {
        Response<DeleteResult> response = new Response();

        try {
            if(this.tradeRepository.existsById(tradeId)) {
                this.tradeRepository.deleteById(tradeId);
                response.setResponse(new DeleteResult(true, "Trade with id " + tradeId + " was successfully deleted."));
                response.setMessage("Success");
                response.setStatusCode(HttpStatus.OK);
            } else {
                response.setResponse(new DeleteResult(false, "Trade with id " + tradeId + " does not exist."));
                response.setMessage("Does Not Exist");
                response.setStatusCode(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setResponse(null);
        }

        return response;
    }


    public Response<List<Trade>> getTrades(int userId) {
        Response<List<Trade>> response = new Response<List<Trade>>();

        try {
            if(this.userRepository.existsById(userId)) {
                response.setResponse(this.tradeRepository.findByUserId(userId));
                response.setStatusCode(HttpStatus.OK);
                response.setMessage("Success");
            } else {
                response.setResponse(null);
                response.setStatusCode(HttpStatus.BAD_REQUEST);
                response.setMessage("User with id: " + userId + " does not exist");
            }

        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setResponse(null);
        }

        return response;
    }
}
