import 'package:flutter/material.dart';
import 'package:pokedex_details/style.dart';

List<Widget> buildList(List<String> items) {
  List<Widget> listOfWidgets = [];
  
  items.forEach((element) {
    String type = element;

    if(type == "Fogo") {
      listOfWidgets.add(
        Container(
          decoration: BoxDecoration(
            color: orangeFire,
            borderRadius: BorderRadius.all(Radius.circular(10)),
          ),
          child: Padding(
            padding: const EdgeInsets.all(8),
            child: Text(
              element,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
                fontSize: 15
              ),
            ),
          ),
        )
      );
    } else if(type == "Água") {
      listOfWidgets.add(
        Container(
          decoration: BoxDecoration(
            color: blueWater,
            borderRadius: BorderRadius.all(Radius.circular(10)),
          ),
          child: Padding(
            padding: const EdgeInsets.all(8),
            child: Text(
              element,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
                fontSize: 15
              ),
            ),
          ),
        )
      );
    } else if(type == "Terra") {
      listOfWidgets.add(
        Container(
          decoration: BoxDecoration(
            color: yellowEarth,
            borderRadius: BorderRadius.all(Radius.circular(10)),
          ),
          child: Padding(
            padding: const EdgeInsets.all(8),
            child: Text(
              element,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
                fontSize: 15
              ),
            ),
          ),
        )
      );
    } else if(type == "Rocha") {
      listOfWidgets.add(
        Container(
          decoration: BoxDecoration(
            color: yellowRock,
            borderRadius: BorderRadius.all(Radius.circular(10)),
          ),
          child: Padding(
            padding: const EdgeInsets.all(8),
            child: Text(
              element,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
                fontSize: 15
              ),
            ),
          ),
        )
      );
    }
    
  });
  return listOfWidgets;
}
