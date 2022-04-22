//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.metadata

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.Name
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.Map

/**
 * Metadata
 *
 * Generated from 'iroha_data_model::metadata::Metadata' regular structure
 */
public data class Metadata(
    public val map: Map<Name, Value>
) {
    public companion object : ScaleReader<Metadata>, ScaleWriter<Metadata> {
        public override fun read(reader: ScaleCodecReader): Metadata = try {
            Metadata(
                reader.readMap(reader.readCompactInt(), { Name.read(reader) }, { Value.read(reader) }),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: Metadata) = try {
            writer.writeCompact(instance.map.size)
            instance.map.toSortedMap(Comparator.comparing(Name::string)).forEach { (key, value) ->  
                Name.write(writer, key)
                Value.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}