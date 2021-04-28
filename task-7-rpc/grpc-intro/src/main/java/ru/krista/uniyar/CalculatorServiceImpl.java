package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;

import javax.inject.Singleton;

@Singleton
public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void calculate(CalculatorProto.CalculatorRequest request,
                          StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        double res = 0;
        switch (request.getOperation()) {
            case ADD:
                res = request.getNumber1() + request.getNumber2();
                break;
            case DIVIDE:
                res = request.getNumber1() / request.getNumber2();
                break;
            case MULTIPLY:
                res = request.getNumber1() * request.getNumber2();
                break;
            case SUBTRACT:
                res = request.getNumber1() - request.getNumber2();
                break;
        }
        responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(res).build());
        responseObserver.onCompleted();
    }
}
