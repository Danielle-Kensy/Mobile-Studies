import 'package:flutter/material.dart';
import 'package:pokedex_details/util/list_widgets.dart';

class Weaknesses extends StatelessWidget {
  final List<String> listOfWeaknesses;
  Weaknesses(this.listOfWeaknesses);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.only(
              top: 20, 
              bottom: 10
              ),
            child: Text(
              "Fraquezas",
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold
              ),
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: buildList(listOfWeaknesses),
          )
        ],
      ),
    );
  }
}