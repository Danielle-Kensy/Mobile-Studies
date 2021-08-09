import 'package:flutter/material.dart';
import 'package:trip_advisor/models/location.dart';
import 'package:trip_advisor/screens/home/widgets/introduction.dart';
import 'package:trip_advisor/screens/home/widgets/top_details.dart';
import 'package:trip_advisor/screens/home/widgets/visit_locations.dart';

class HomePage extends StatelessWidget {
  final location = Location(
    header: "assets/images/Banner.jpg", 
    locationName: "Paris - França", 
    ratings: 32, 
    introTitle: "Conheça as maravilhas da capital Francesa", 
    introDescription: "É impossível não se render aos encantos de Paris, a bela capital francesa e destino turístico frequentado por milhões de pessoas todos os anos. Vibrante, charmosa, romântica, divertida, além de berço da cultura e da arte, a Cidade Luz, como é chamada, possui uma infindável lista de qualidades.", 
    locationPictures: ["assets/images/foto_1.jpg", "assets/images/foto_2.jpg", "assets/images/foto_3.jpg", "assets/images/foto_4.jpg", "assets/images/foto_5.jpg", "assets/images/foto_6.jpg", "assets/images/foto_7.jpg", "assets/images/foto_8.jpg", "assets/images/foto_9.jpg",],
    locationNames: ["Musée d'Orsay", "Catedral de Notre-Dame", "Sainte-Chapelle", "Museu do Louvre", "Arco do Triunfo", "Palais Garnier", "Jardim de Luxemburgo", "Seine River", "Torre Eiffel"]);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          
          children: [
            Image.asset(location.header),
            Column(
              children: [
                Padding(
                  padding: const EdgeInsets.all(10),
                  child: TopDetails(location),
                ),
                Introduction(location),
                VisitLocations(location)
              ],
            )
          ],
        ),
      ),
    );
  }
}
