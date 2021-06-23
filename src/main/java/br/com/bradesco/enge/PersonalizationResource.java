package br.com.bradesco.enge;

import io.agroal.api.AgroalDataSource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Array;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.chrono.HijrahDate;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@RequestScoped
public class PersonalizationResource {

    @Inject
    AgroalDataSource dataSource;

    @Inject
    PersonalizationService service;

    @POST
    @Path("/run")
    public String run(Args args) throws Exception {
        var agencia = Integer.parseInt(args.getAgencia());
        var conta = Integer.parseInt(args.getConta());

        List<String> ListOrders = args.getOrders();
        String[] arrayOrders = ListOrders.toArray(new String[ListOrders.size()]);

        try (var conn = this.dataSource.getConnection()) {
            Array sqlOrders = conn.createArrayOf("VARCHAR", arrayOrders);
            this.service.updateOrder(conn, agencia, conta, sqlOrders);
        } catch (Exception e) {
            System.out.println(e);
        };
        return "";
    }

    @GET
    @Path("/init")
    public Instant init() throws Exception {
        return Instant.now();
    }
}
