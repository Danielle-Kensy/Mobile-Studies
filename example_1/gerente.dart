import 'endereco.dart';

class Gerente {
  int? _matricula;
  String? _nome;
  String? _email;
  String? _telefoneParaContato;
  int? _ramal;
  Endereco? _endereco;

  Gerente (
    this._matricula,
    this._nome,
    this._email,
    this._telefoneParaContato,
    this._ramal,
    this._endereco,
  );

  // int? get matricula => this._matricula;
  // String? get nome => this._nome;
  // String? get email => this._email;
  // String? get telefone => this._telefoneParaContato;
  // int? get ramal => this._ramal;
  // Endereco? get endereco => this._endereco;

  // set matricula(int? matricula) {
  //   this._matricula = matricula;
  // }

  // set nome(String? nome) {
  //   this._nome = nome;
  // }

  // set email(String? email) {
  //   this._email = email;
  // }

  // set telefone(String? telefone) {
  //   this._telefoneParaContato = telefone;
  // }

  // set ramal(int? ramal) {
  //   this._ramal = ramal;
  // }

  // set endereco(Endereco? endereco) {
  //   this._endereco = endereco;
  // }
}
