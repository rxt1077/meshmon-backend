# meshmon-backend

A simple API backend and MeshPacket capture utility for use with
[MeshMon](https://github.com/rxt1077/MeshMon).

Currently it only saves Telemetry, NodeInfo, and Position MeshPackets. 

## Usage

```console
$ java -jar target/meshmon-backend-0.1.0-standalone.jar --help
2022-12-21 08:53:32.780:INFO::main: Logging initialized @1651ms to org.eclipse.jetty.util.log.StdErrLog

Usage is meshmon-backend [options]

Options:
  -r, --record                                record packets from device
  -s, --serial PORT                           use serial PORT for recording (autodetects if not specified)
  -p, --port PORTNUM  5000                    TCP port for HTTP connections
  -t, --static DIR    ./static                static files directory
  -u, --url URL       jdbc:sqlite:packets.db  jdbc URL for database
  -h, --help                                  display this help message
```

## Workflows

When a tag is pushed and new release will be automatically created through GitHub actions.

## Protobufs

This project uses [pronto](https://github.com/AppsFlyer/pronto) to handle protobufs in clojure.
It also used [lein-protodeps](https://github.com/AppsFlyer/) to automatically pull and compile protobufs from [the Meshtastic Protobuf Definitions repo](https://github.com/meshtastic/protobufs).

If you need to update the protobufs, running `lein protodeps generate` should suffice.

## Of Camels, Snakes, and Kebabs

Every effort has been made to use the correct label style for how something is stored/used.
If it is being used in a Clojure program it is presented in kebab case.
If it is being stored in the DB column it uses snake case.
If it is being stored or exchanged as JSON it uses camelCase.
