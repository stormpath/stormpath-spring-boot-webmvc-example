package com.stormpath.example.service;

import com.stormpath.example.model.MathRequest;
import com.stormpath.example.model.MathResponse;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public MathResponse compute(MathRequest req) {
        MathResponse res = new MathResponse();

        if (req.getOperation() == null || req.getOperation().length() == 0) {
            res.setStatus(MathResponse.Status.ERROR);
            res.setMsg("Operation must not be null or empty.");

            return res;
        }

        res.setStatus(MathResponse.Status.SUCCESS);
        res.setMsg("Operation '" + req.getOperation() + "' is successful.");
        res.setInput(req.getNum());
        res.setOperation(req.getOperation());

        switch (req.getOperation()) {
            case "double":
                res.setResult(req.getNum() * 2);
                break;
            case "square":
                res.setResult(req.getNum() * req.getNum());
                break;
            default:
                res.setStatus(MathResponse.Status.ERROR);
                res.setMsg("Only 'double' and 'square' operations supported.");
                res.setOperation(null);
                res.setInput(null);
        }

        return res;
    }
}
