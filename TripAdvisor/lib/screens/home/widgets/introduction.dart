import 'package:flutter/material.dart';
import 'package:trip_advisor/models/location.dart';
import 'package:trip_advisor/style.dart';

class Introduction extends StatelessWidget {
  final Location _locationObj;

  Introduction(this._locationObj);
  
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(
        horizontal: 20
      ),
      child: Column(
          children: [
            Column(
              children: [
                Padding(
                  padding: const EdgeInsets.only(
                    bottom: 10
                  ),
                  child: Text(
                    _locationObj.introTitle,
                    style: TextStyle(
                      color: greenText,
                      fontWeight: FontWeight.bold,
                      fontSize: 20
                    ),
                  ),
                ),
              ],
            ),
            Column(
              children: [
                Text(
                  _locationObj.introDescription,
                  style: TextStyle(
                    fontSize: 12
                  ),
                )
              ],
            )
          ],
        ),
    );
  }
  
}