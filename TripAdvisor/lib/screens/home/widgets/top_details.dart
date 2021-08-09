import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:trip_advisor/models/location.dart';
import 'package:trip_advisor/style.dart';

class TopDetails extends StatelessWidget {
  final Location _locationObj;

  TopDetails(this._locationObj);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Column(
            children: [
              Row(
                children: [
                  FaIcon(
                    FontAwesomeIcons.mapMarkerAlt,
                    color: greyText,
                  ),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 10
                    ),
                    child: Text(
                      _locationObj.locationName,
                      style: TextStyle(
                        color: greyText,
                        fontWeight: FontWeight.bold
                      ),
                    ),
                  )
                ],
              )
            ],
          ),
          Column(
            children: [
              Row(
                children: [
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 2
                    ),
                    child: FaIcon(
                    FontAwesomeIcons.solidStar,
                      color: orangeStar,
                      size: 14,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 2
                    ),
                    child: FaIcon(
                      FontAwesomeIcons.solidStar,
                      color: orangeStar,
                      size: 14,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 2
                    ),
                    child: FaIcon(
                      FontAwesomeIcons.solidStar,
                      color: orangeStar,
                      size: 14,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 2
                    ),
                    child: FaIcon(
                      FontAwesomeIcons.solidStar,
                      color: orangeStar,
                      size: 14,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 2
                    ),
                    child: FaIcon(
                      FontAwesomeIcons.solidStar,
                      color: greyText,
                      size: 14,
                    ),
                  )
                ],
              )
            ],
          ),
          Column(
            children: [
              Row(
                children: [
                  Text(
                    "${_locationObj.ratings} avaliações",
                    style: TextStyle(
                      color: greyText
                    ),
                  )
                ],
              )
            ],
          )
        ],
      ),
    );
  }

}