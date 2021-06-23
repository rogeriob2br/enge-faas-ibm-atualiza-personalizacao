package br.com.bradesco.enge;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
public class Args {

  private String agencia;
  private String conta;
  private List<String> orders;
  private String databaseUri;
  private String databaseUser;
  private String databasePassword;

  public Args() {
    super();
  }

  public Args(String agencia, String conta, String databaseUri, String databaseUser, String databasePassword) {
    this.agencia = agencia;
    this.conta = conta;
    this.databasePassword = databasePassword;
    this.databaseUri = databaseUri;
    this.databaseUser = databaseUser;
  }

  public String getDatabasePassword() {
    return databasePassword;
  }

  public String getDatabaseUri() {
    return databaseUri;
  }

  public String getDatabaseUser() {
    return databaseUser;
  }

  public void setDatabasePassword(String databasePassword) {
    this.databasePassword = databasePassword;
  }

  public void setDatabaseUri(String databaseUri) {
    this.databaseUri = databaseUri;
  }

  public void setDatabaseUser(String databaseUser) {
    this.databaseUser = databaseUser;
  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getConta() {
    return conta;
  }

  public void setConta(String conta) {
    this.conta = conta;
  }

  public List<String> getOrders() {
    return orders;
  }

  public void setOrders(List<String> orders) {
    this.orders = orders;
  }
}
