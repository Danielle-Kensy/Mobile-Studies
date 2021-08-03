import 'package:flutter/material.dart';
import 'package:pokedex_details/models/pokemon.dart';
import 'package:pokedex_details/style.dart';
import 'package:pokedex_details/util/list_widgets.dart';

class Stats extends StatelessWidget {
  final Pokemon _pokemonObj;
  Stats(this._pokemonObj);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: blueTheme,
        borderRadius: BorderRadius.all(Radius.circular(5))
      ),

      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Padding(
                padding: const EdgeInsets.all(20),
                child: Column(
                  children: [
                    Text(
                      "Altura",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                        color: Colors.white
                      )
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Text(
                      "${_pokemonObj.height} m",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 20, 45, 20),
                child: Column(
                  children: [
                    Text(
                      "Peso",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                        color: Colors.white
                      )
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Text(
                      "${_pokemonObj.weight} kg",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                  ],
                ),
              ),
            ]
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 0, 20, 20),
                child: Column(
                  children: [
                    Text(
                      "Tipo",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                        color: Colors.white
                      )
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Padding(
                      padding: const EdgeInsets.all(5),
                      child: Column(
                        children: buildList(_pokemonObj.type),
                      ),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.fromLTRB(20, 0, 20, 20),
                child: Column(
                  children: [
                    Text(
                      "Habilidade",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                        color: Colors.white
                      )
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Text(
                      "${_pokemonObj.skill}",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                  ],
                ),
              ),
            ]
          )
        ],
      ),
    );
  }

}