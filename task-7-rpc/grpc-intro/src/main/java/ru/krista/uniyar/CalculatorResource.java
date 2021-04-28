package ru.krista.uniyar;

import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @Inject
    @GrpcService("calculator")
    CalculatorServiceGrpc.CalculatorServiceBlockingStub client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/plus/{number1}/{number2}")
    public String plus(@PathParam("number1") double number1,
                       @PathParam("number2") double number2) {
        CalculatorProto.CalculatorRequest req = CalculatorProto.CalculatorRequest.newBuilder()
                .setNumber1(number1)
                .setNumber2(number2)
                .setOperation(CalculatorProto.CalculatorRequest.OperationType.ADD).build();

        CalculatorProto.CalculatorResponse response = client.calculate(req);
        return String.valueOf(response.getResult());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/divide/{number1}/{number2}")
    public String divide(@PathParam("number1") double number1,
                       @PathParam("number2") double number2) {
        CalculatorProto.CalculatorRequest req = CalculatorProto.CalculatorRequest.newBuilder()
                .setNumber1(number1)
                .setNumber2(number2)
                .setOperation(CalculatorProto.CalculatorRequest.OperationType.DIVIDE).build();

        CalculatorProto.CalculatorResponse response = client.calculate(req);
        return String.valueOf(response.getResult());
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/subtract/{number1}/{number2}")
    public String subtract(@PathParam("number1") double number1,
                         @PathParam("number2") double number2) {
        CalculatorProto.CalculatorRequest req = CalculatorProto.CalculatorRequest.newBuilder()
                .setNumber1(number1)
                .setNumber2(number2)
                .setOperation(CalculatorProto.CalculatorRequest.OperationType.SUBTRACT).build();

        CalculatorProto.CalculatorResponse response = client.calculate(req);
        return String.valueOf(response.getResult());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/multiply/{number1}/{number2}")
    public String multiply(@PathParam("number1") double number1,
                           @PathParam("number2") double number2) {
        CalculatorProto.CalculatorRequest req = CalculatorProto.CalculatorRequest.newBuilder()
                .setNumber1(number1)
                .setNumber2(number2)
                .setOperation(CalculatorProto.CalculatorRequest.OperationType.MULTIPLY).build();

        CalculatorProto.CalculatorResponse response = client.calculate(req);
        return String.valueOf(response.getResult());
    }
}