import 'package:flutter/material.dart';

class Description extends StatelessWidget {
  final String description;
  Description(this.description);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(
        vertical: 10
      ),
      child: Container(
        child: Column(
          children: [
            Text(description)
          ],
        ),
      ),
    );
  }

}