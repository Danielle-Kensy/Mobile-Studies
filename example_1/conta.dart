import 'agencia.dart';
import 'cliente.dart';

class Conta {
  // Atributos
  String? _numero;
  Agencia? _agencia;
  Cliente? _cliente;
  double _saldo = 200;
  double? _limite;

  Conta (
    this._numero,
    this._agencia,
    this._cliente,
    this._saldo,
    this._limite
  );

  // String? get getNumero => this._numero;
  // Agencia? get agencia => this._agencia;
  // Cliente? get cliente => this._cliente;
  // double? get limite => this._limite;

  // set numero(String? numero) {
  //   this._numero = numero;
  // }

  // set agencia(Agencia? agencia) {
  //   this._agencia = agencia;
  // }

  // set cliente(Cliente? cliente) {
  //   this._cliente = cliente;
  // }

  //Métodos
  double? obterSaldo() {
    return this._saldo;
  }

  double? sacar(double valor) {
    // Retirar da valor da conta
    this._saldo = this._saldo - valor;
    return valor;
  }

  bool depositar(double valor) {
    // saldo(300) = saldo(200) + valor(100)
    this._saldo = this._saldo + valor;
    return true;
  }

  bool transferir(double valor, Conta destino) {
    // Da origem
    this.sacar(valor);
    // Na destino
    destino.depositar(valor);
    return true;
  }
}
