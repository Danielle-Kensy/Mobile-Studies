import '../funcionario.dart';

class Funcionarios {
  static List<Funcionario> _funcionarios = [];

  void cadastrar(Funcionario funcionario) {
    _funcionarios.add(funcionario);
  }

  Iterable<Funcionario> buscar(int matricula) {
    return _funcionarios
        .where((objFuncionario) => objFuncionario.matricula == matricula);
  }

  List<Funcionario> listar() {
    return _funcionarios;
  }

  void remover(int matricula) {
    Iterable<Funcionario> listaDeFuncionarios = buscar(matricula);

    listaDeFuncionarios.forEach((funcionario) {
      _funcionarios.remove(funcionario);
    });
  }

  void editar(Funcionario objFuncionario) {
    Iterable<Funcionario> listaDeFuncionarios =
        buscar(objFuncionario.matricula);

    listaDeFuncionarios.forEach((antigoFuncionario) {
      antigoFuncionario = objFuncionario;
    });
  }
}
